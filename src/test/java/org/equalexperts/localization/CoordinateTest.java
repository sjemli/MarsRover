package org.equalexperts.localization;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CoordinateTest {

    @Test
    void should_create_coordinate_with_x_equal_to_5_and_y_equal_to_2(){
        Coordinate coordinate = new Coordinate(5, 2);
        assertThat(coordinate.getX(), equalTo(5));
        assertThat(coordinate.getY(), equalTo(2));
    }

    @Test
    void should_coordinate_be_equal_and_have_same_hashcode_when_having_same_attributes(){
        Coordinate coordinate1 = new Coordinate(99,22);
        Coordinate coordinate2 = new Coordinate(99,22);

        assertEquals(coordinate1, coordinate2);
        assertEquals(coordinate2, coordinate1);
        assertEquals(coordinate1.hashCode(), coordinate2.hashCode());
    }
}