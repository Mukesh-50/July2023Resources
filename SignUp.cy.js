
/// <reference types="Cypress"/>



describe('SignUp Test ', () => {
  it('SignUp With Valid Credentials', () => {
    cy.viewport(1920, 1080)
    cy.visit('https://freelance-learn-automation.vercel.app/signup')
    const signupbtn=cy.get("button[type='submit']")
    signupbtn.should('be.disabled')
    cy.get("input[name='name']").type("Ritika Kanchan",{force: true})
    let email = "ritika"+ Date.now()
    cy.get("input[name='email']").type(email+"@abc.com")
    cy.get("input[name='password']").type("abcdefgh")
   cy.get('label').contains('Automation Testing').click()
   cy.get('label').contains('Performance Testing').click() 
   cy.get("input[value='Female']").click()
   cy.get("select[name='state']").select('Chandigarh')
   cy.get("select[name='hobbies']").select(['Playing','Reading'])
   signupbtn.should('be.enabled')
   cy.get("button[type='submit']").click()

   
   cy.xpath('//div[contains(text(),"Signup successfully")]').should('to') //'Signup successfully')





  });

})