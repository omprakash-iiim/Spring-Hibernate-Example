# technoscatter:

Its an example of Spring Hibernate Integration using java based configuration. This example will store, update, delete the customer information in a database.

In the database side, use the folowing query to create a customer table in mysql

CREATE TABLE CUSTOMER(
    id INT NOT NULL AUTO_INCREMENT,
    account_number VARCHAR(30) NOT NULL UNIQUE,
    NAME VARCHAR(50) NOT NULL,
    date_of_birth DATE NOT NULL,
    PRIMARY KEY (id)
);
