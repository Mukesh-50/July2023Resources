/// <reference types="Cypress"/>



describe('Login Test', () => {
    it('Login Test With valid Credentials', () => {
        cy.viewport(1920, 1080)
        cy.visit('https://freelance-learn-automation.vercel.app/login')
        cy.get("input[name='email1']").type("admin@email.com")
    cy.get("input[name='password1']").type("admin@123")
    cy.get("button[type='submit']").click()

    cy.xpath("//div[@class='home']//h4[@class='welcomeMessage']").should('contain.text','Welcome')

/*
    cy.get('button').contains('Add to Cart').click()
    cy.get("button[class='cartBtn']").click()
    cy.get("div[class='course-card row']").should('have.length.greaterThan',0)
    cy.get('button').contains('Enroll Now').click()
    cy.xpath('//div[@role="dialog"]//div//div//div//textarea').type("Chandigarh") */
});
    
});