/// <reference types="Cypress"/>



describe('Login Test', () => {
    it('Login Test With valid Credentials', () => {
        cy.visit('https://freelance-learn-automation.vercel.app/login')
        cy.get("input[name='email1']").type("admin@email.com",{force: true})
    cy.get("input[name='password1']").type("admin@123",{force: true})
    cy.get("button[type='submit']").click({force: true})
    cy.get('button').contains('Add to Cart').click({force: true})
    cy.get("button[class='cartBtn']").click({force: true})
    cy.get("div[class='course-card row']").should('have.length.greaterThan',0)
    cy.get('button').contains('Enroll Now').click({force: true})
    cy.xpath('//div[@role="dialog"]//div//div//div//textarea').type("Chandigarh",{force: true})
});
    
});