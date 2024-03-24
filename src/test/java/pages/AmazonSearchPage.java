package pages;

public class AmazonSearchPage extends BasePage {

  private String searchBox = "//input[@id='twotabsearchtextbox']";
  private String searchButton = "//input[@id='nav-search-submit-button']";
  private String linkText_a = "//span[@class='s-pagination-strip']/a[1]";
  private String linkTextUl = "//span[@class='s-pagination-strip']/ul/li[2]";
  private int ItemNumber = 3;
  private String thirdItem = String.format("//body/div[@id='a-page']/div[@id='search']/div[@class='s-desktop-width-max "
      + "s-desktop-content s-opposite-dir s-wide-grid-style sg-row']/div[@class='sg-col-20-of-24 s-matching-dir "
      + "sg-col-16-of-20 sg-col sg-col-8-of-12 sg-col-12-of-16']/div[@class='sg-col-inner']/span[@class='rush-component "
      + "s-latency-cf-section']/div[@class='s-main-slot s-result-list s-search-results sg-row']/div[%d]"
      + "/div[1]/div[1]/span[@class='a-declarative']/div[1]/div[1]/div[1]/div[1]/div[1]",
      ItemNumber + 1);
  // Diferentes botones para Adicionar al carrito
  private String addToCartButton1 = "//input[@id='add-to-cart-button']";
  private String addToCartButton2 = "//span[@id='dealsx_atc_btn']";
  private String addToCartButton3 = "//input[@id='add-to-cart-button-ubb']";
  // Definir el leguaje
  private String enLanguage = "html[@lang='en-us']";
  private String esLanguage = "html[@lang='es-us']";
  // Diferentes Posibles mensajes que retorna cuando se intenta agreagar
  private String addedMessageText = "//div[@id='sw-atc-details-single-container']/div[2]/div[1]/div[1]";
  private String deliveryBlock = "//div[@id='mir-layout-DELIVERY_BLOCK-slot-PRIMARY_DELIVERY_MESSAGE_LARGE']";
  private String outOfStock = "//div[@id='outOfStock']/div[1]/div[1]/span[@class='a-color-price a-text-bold']";
  private String signInForm = "//label[@class='a-form-label']";
  private String noOffers = "//div[@id='fod-cx-box']/div[1]/span[1]";
  // Conseguir el mensaje retornado
  private String finalMessage = "";

  // Usamos el Contructor del padre
  public AmazonSearchPage() {
    super(driver);
  }

  public void navegateToAmazon() {
    navigateTo("https://amazon.com");
  }

  public void enterSearchCriteria(String criteria) {
    writeElement(searchBox, criteria);
  }

  public void clickSearch() {
    clickElement(searchButton);
  }

  public void goToPage2() {
    try {
      clickElement(linkText_a);
    } catch (Exception e) {
      clickElement(linkTextUl);
    }
  }

  public void pick3rdItem() {
    clickElement(thirdItem);
  }

  public void addToCart() {
    try {
      clickElement(addToCartButton1);
    } catch (Exception e1) {
      try {
        clickElement(addToCartButton2);
      } catch (Exception e2) {
        try {
          clickElement(addToCartButton3);
        } catch (Exception e3) {
          System.err.println(e3);
        }
      }
    }
  }

  public String getLanguage() {
    String language = "none";
    if (elementIsEnabled(enLanguage)) {
      language = "en";
    } else if (elementIsEnabled(esLanguage)) {
      System.out.println("Español");
      language = "es";
    }
    System.out.println("Language:" + language);
    return language;
  }

  public String addedToCartMessage() {
    try {
      finalMessage = textFromElement(signInForm);
    } catch (Exception e1) {
      try {
        finalMessage = textFromElement(addedMessageText);
      } catch (Exception e2) {
        try {
          finalMessage = textFromElement(deliveryBlock);
        } catch (Exception e3) {
          try {
            finalMessage = textFromElement(outOfStock);
          } catch (Exception e4) {
            finalMessage = textFromElement(noOffers);
          }
        }
      }
    }
    System.out.println("Current message: " + finalMessage);
    return finalMessage;
  }

}
