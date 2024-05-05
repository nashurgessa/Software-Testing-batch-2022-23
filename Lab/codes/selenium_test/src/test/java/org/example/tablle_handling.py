import unittest
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

class TableHandlingTest(unittest.TestCase):
    @classmethod
    def setUp(cls):
        # service = Service()
        # Provide the path to the Edge WebDriver executable
        # webdriver_path = "E:/Source_code/NodeJs/Software-Testing-batch-2022-23/Lab/codes/selenium_test/src/test/resources/msedgedriver.exe"
        cls.driver = webdriver.Edge()
        # cls.driver = webdriver.Edge("E:/Source_code/NodeJs/Software-Testing-batch-2022-23/Lab/codes/selenium_test/src/test/resources/msedgedriver")
        cls.driver.get("http://localhost:63342/selenium_test/Lab/codes/selenium_test/src/test/resources/table_demo.html?_ijt=vlfifsajctmjgclc7jg8gbr3q2&_ij_reload=RELOAD_ON_SAVE")
        cls.driver.maximize_window()

    def test_read_table(self):
        WebDriverWait(self.driver, 10).until(EC.visibility_of_element_located((By.ID, 'data-table')))
        # Access the WebDriver instance created in setUpClass
        # driver = self.driver
        print("Hello: ", self.driver)
        # Locate the table
        table = self.driver.find_element_by_id('data-table')

        # Fetch all rows of the table
        rows = table.find_elements_by_tag_name('tr')

        # Print data from each row
        for row in rows:
            cols = row.find_elements_by_tag_name('td')  # Get columns for each row
            for col in cols:
                print(col.text, end='\t')
            print()  # for new line after each row

#     @classmethod
#     def tearDown(self):
#         cls.driver.quit()


if __name__ == "__main__":
    unittest.main()