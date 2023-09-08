
/// <reference types="Cypress"/>



describe('SignUp Test ', () => {
  it('SignUp With Valid Credentials', () => {
    cy.visit('https://freelance-learn-automation.vercel.app/signup')
    const signupbtn=cy.get("button[type='submit']")
    signupbtn.should('be.disabled')
    cy.get("input[name='name']").type("Ritika Kanchan",{force: true})
    let email = "ritika"+ Date.now()
    cy.get("input[name='email']").type(email+"@abc.com",{force: true})
    cy.get("input[name='password']").type("abcdefgh",{force: true})
   cy.get('label').contains('Automation Testing').click({force: true})
   cy.get('label').contains('Performance Testing').click({force: true})
   cy.get("input[value='Female']").click({force: true})
   cy.get("select[name='state']").select('Chandigarh')
   cy.get("select[name='hobbies']").select(['Playing','Reading'])
   signupbtn.should('be.enabled')
   signupbtn.click({force: true})



  })

})