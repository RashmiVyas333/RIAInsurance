package Utility;

public class TestContext {
    private WebDriverManagerUtil webDriverManagerUtil;
	private PageObjectManager pageObjectManager;
	private ScenarioContext scenarioContext;
	
	public TestContext(){
		webDriverManagerUtil = new WebDriverManagerUtil();
		pageObjectManager = new PageObjectManager(webDriverManagerUtil.getDriver());
		scenarioContext = new ScenarioContext();
	}
	
	public WebDriverManagerUtil getWebDriverManagerUtil() {
		return webDriverManagerUtil;
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

	public ScenarioContext getScenarioContext(){
		return scenarioContext;
	}
    
}
