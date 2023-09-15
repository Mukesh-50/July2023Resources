/// <reference types="Cypress"/>



describe('Add Course Test', () => {
    it('Add Course - Cypress with JavaScript', () => {
        cy.visit('https://freelance-learn-automation.vercel.app/login')
        cy.get("input[name='email1']").type("admin@email.com")
    cy.get("input[name='password1']").type("admin@123")
    cy.get("button[type='submit']").click()
    cy.get('span').contains('Manage').realHover()
    cy.get('a').contains('Manage Courses').click()
    cy.get('').each("")
    });
    
});