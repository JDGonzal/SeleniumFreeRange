package pages;

public class GridPage extends BasePage {

  String grid = "//*[@id='root']/div/";
  String mainTable = "//*[@id='root']/div/table";

  // Usamos el Contructor del padre
  public GridPage() {
    super(driver);
  }

  public void navigateToGrid() {
    // Esta URL existe y es del sitio https://codesandbox.io/
    navigateTo("https://1v2njkypo4.csb.app/");
  }

  public String getValueFromGrid(int row, int col) {
    return getValueFromTable(grid, row, col);
  }

  public boolean cellStatus() {
    return elementIsDisplayed(mainTable);
  }
}
