package dropdown;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DropdownPage;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownTests extends BaseTests {

    @Test
    public void testSelectOption(){
        String option = "Option 1";
        DropdownPage dropdownPage;
        dropdownPage = homePage.clickDropdown();
        dropdownPage.selectFromDropDown(option);
        List<String> selectedOptions = dropdownPage.getSelectedOptions();
        assertEquals(selectedOptions.size(), 1, "Incorrect number of selected elements");
        assertTrue(selectedOptions.contains(option), "Option not selected!");
    }
}
