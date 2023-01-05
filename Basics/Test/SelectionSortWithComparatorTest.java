import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.Test;

import helperObjects.*;

public class SelectionSortWithComparatorTest {

  @Test
  public void selectionSort_BACStringList_ReturnsABC() {
    String[] arrayOfStrings = {"B", "A", "C"};
    String[] correctResult = {"A", "B", "C"};

    arrayOfStrings = SelectionSortWithComparator.selectionSort(arrayOfStrings, String.CASE_INSENSITIVE_ORDER);

    assertThat(arrayOfStrings, equalTo(correctResult));
  }

  @Test
  public void selectionSort_GeometricObjectList_ReturnsOrderedList() {
    Circle c1 = new Circle(1);
    Circle c2 = new Circle(5);
    Rectangle r1 = new Rectangle(8,10);
    GeometricObject[] list = {c2,c1,r1};
    GeometricObject[] correctResult = {c1,c2,r1};

    list = SelectionSortWithComparator.selectionSort(list, new GeometricObjectComparator());

    assertThat(list, equalTo(correctResult));
  }
}