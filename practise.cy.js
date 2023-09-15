/// <reference types="Cypress"/>

describe('Mouse Hover', () => {
    it('Naukri Application', () => {
        cy.visit('https://seleniumpractise.blogspot.com/2016/08/how-to-perform-mouse-hover-in-selenium.html?m=1')
       cy.xpath('//button[contains(text(),"Automation Tools")]').realHover()
   
    });
});