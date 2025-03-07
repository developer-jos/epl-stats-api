describe('Login Flow', () => {
    it('Logs in using Auth0', () => {
        cy.visit('http://localhost:3000');  // Replace with your frontend URL

        cy.get('[data-testid="login-button"]').click();
        cy.origin('https://dev-uttljpo124lcbbk2.us.auth0.com', () => {
            cy.get('input[name="username"]').type('testuser@gmail.com');
            cy.get('input[name="password"]').type('mypassword{enter}');
        });

        cy.url().should('contain', '/dashboard');
    });
});
