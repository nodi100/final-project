package StepObject;

import PageObject.SearchElements;

import static DataObject.SearchData.searchWord;

public class SearchSteps extends SearchElements {

    public SearchSteps enterSearchWord (String searchWord) {
        searchInput.sendKeys(searchWord);
        return this;
    }


    public void search () {
        SearchSteps steps = new SearchSteps();
        steps.enterSearchWord(searchWord);
    }

}
