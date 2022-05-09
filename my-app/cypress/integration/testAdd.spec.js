describe('My HTML/JS Tests', () => {
    it('good addition in calculatrice', () => {
  
      //partir de index.html
      cy.visit("http://localhost:4200/index.html")
  
      //cliquer sur le lien comportant 'calculatriceV3'
      cy.contains('welcome').click()
      cy.wait(50)
      // Should be on a new URL which includes '/calculatrice'
      cy.url().should('include', '/welcome')
  
      // Get an input, type data into it 
      //and verify that the value has been updated
      cy.get('#a')
        .clear()
        .type('5')
        .should('have.value', '5')
  
      cy.get('#b')
        .clear()
        .type('6')
        .should('have.value', '6')
  
      //declencher click sur bouton addition
      cy.get('#btn_op_addition')
        .click()
  
      //vérifier que la zone d'id spanRes comporte le texte '11'
      cy.get('#spanRes')
        .should('have.text', '11')
    })
})