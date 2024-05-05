import unittest
from selenium import webdriver
from selenium.webdriver.edge.service import Service
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

class TableHandlingTest(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        # Initialize the Edge WebDriver
        # s = Service("E:/Source_code/NodeJs/Software-Testing-batch-2022-23/Lab/codes/selenium_test/src/test/resources/msedgedriver.exe")
        cls.driver = webdriver.Edge()
        cls.driver.get("file:///E:/Source_code/NodeJs/Software-Testing-batch-2022-23/Lab/codes/selenium_test/src/test/resources/table_demo.html")
        cls.driver.maximize_window()

    def test_read_table(self):
        # Ensure the table is visible before accessing it
        # WebDriverWait(self.driver, 10).until(EC.visibility_of_element_located((By.ID, 'data-table')))
        table = self.driver.find_element(By.ID, 'data-table')
        rows = table.find_elements(By.TAG_NAME, 'tr')

        # Print data from each row
        for row in rows:
            cols = row.find_elements(By.TAG_NAME, 'td')  # Get columns for each row
            for col in cols:
                print(col.text, end='\t')
            print()  # for new line after each row

    @classmethod
    def tearDownClass(cls):
        cls.driver.quit()

if __name__ == "__main__":
    unittest.main()
