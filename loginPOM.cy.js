import Login from "../pages/login.cy";
/// <reference types="Cypress"/>

describe('Login with POM', () => {
    it('Login with Valid Credentials', () => {

        const login=new Login() ; // creating object for Login class
        cy.visit("https://freelance-learn-automation.vercel.app/")
        login.enterUserName.type("admin2email.com")
        login.enterPassword.type("admin@123")
        login.clickOnSubmit.click()

        
    });
});