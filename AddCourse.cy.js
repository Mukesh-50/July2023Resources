/// <reference types="Cypress"/>



describe('Add Course Test', () => {
    it('Add Course - Cypress with JavaScript', () => {
        cy.viewport(1920, 1080)
        cy.visit('https://freelance-learn-automation.vercel.app/login')
        cy.get("input[name='email1']").type("admin@email.com")
    cy.get("input[name='password1']").type("admin@123")
    cy.get("button[type='submit']").click()
    cy.get('span').contains('Manage').realHover()
    cy.wait(2000);
    cy.xpath("//a[normalize-space()='Manage Courses']").scrollIntoView().should('be.visible').click();
    let noOfCourses ; // number of courses before adding a new course
    cy.xpath("//table[@class='courses-table table table-borderless']").find("tr").then((rows)=>
    {
        noOfCourses =(rows.length)-1;
        cy.log(rows.length);
        cy.wrap(noOfCourses).as('noOfCourses')
    });
   // cy.get('sidebar ').scrollTo('top')

  cy.xpath("//button[normalize-space()='Add New Course']").scrollIntoView().should('be.visible').click({force:true});
  cy.get("input[id='thumbnail']").attachFile('images/download.jpg');
  cy.get("input[id='name']").type("API Testing");
  cy.get("textarea[id='description']").type("Postman");
  cy.get("input[name='instructorName']").type("Ritika");
  cy.get("input[name='price']").clear();
  cy.get("input[name='price']").type("10000");
  cy.get("input[name='startDate']").click();
  cy.get("div[aria-label='Choose Saturday, September 30th, 2023']").click();
  cy.get("input[name='endDate']").click();
  cy.get("div[aria-label='Choose Wednesday, October 18th, 2023']").click();
  cy.xpath("//div[normalize-space()='Select Category']").click();
  cy.xpath("//button[normalize-space()='Automation Testing']").click();
  cy.xpath("//button[normalize-space()='Save']").click();

  let updatedrows;

  cy.xpath("//table[@class='courses-table table table-borderless']").find("tr").then((rows)=>
    {
        updatedrows =(rows.length)-1;
        cy.log(rows.length);
        cy.wrap(updatedrows).as('updatedrows');
    });
assert(updatedrows).to.be.greaterThan(noOfCourses);
 
    });
    
});