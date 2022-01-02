Feature: Formulario de registro de estudiante en demoqa.com con el patron Screenplay

  Description:
  Yo como automatizador de pruebas
  Necesito automatizar el flujo de registro de estudiante
  Para validar funcionalidad exitosa

  Background:
    Given Yo Ingreso a la plataforma de registro estudiante demoqa


  @CP001
  Scenario Outline: Validar diligenciamiento exitoso de campos del formulario
    And Yo cargo los datos del estudiante
      | firstName   | lastName   | email   | gender   | mobileNumber   | dateBirth   | subjects   | hobbies   | file   | currentAddress   | state   | city   | expected   |
      | <firstName> | <lastName> | <email> | <gender> | <mobileNumber> | <dateBirth> | <subjects> | <hobbies> | <file> | <currentAddress> | <state> | <city> | <expected> |
    When Yo diligencio el formulario de registro
    Then Yo verifico que se muestre el mensaje esperado

    Examples:
      | firstName | lastName | email            | gender | mobileNumber | dateBirth  | subjects              | hobbies       | file         | currentAddress                        | state   | city   | expected                       |
      ##@externaldata@./src/test/resources/data/Testdata.xlsx@Sheet1@1
   |Pedro   |Pablo   |pedro@correo.com   |Male   |3121234567   |30-04-2010   |Physics, Maths, Hindi   |Sports, Music   |original.png   |Calle 32 #12-12 Las Brisas – Medellin   |Haryana   |Karnal   |Thanks for submitting the form|



  @CP002
  Scenario Outline: Validar diligenciamiento exitoso de campos del formulario y datos en ventana de confirmacion
    And Yo cargo los datos del estudiante
      | firstName   | lastName   | email   | gender   | mobileNumber   | dateBirth   | subjects   | hobbies   | file   | currentAddress   | state   | city   | expected   |
      | <firstName> | <lastName> | <email> | <gender> | <mobileNumber> | <dateBirth> | <subjects> | <hobbies> | <file> | <currentAddress> | <state> | <city> | <expected> |
    When Yo diligencio el formulario de registro
    Then Yo verifico que se muestre el mensaje esperado
    And Yo verifico los datos en la ventana de confirmacion

    Examples:
      | firstName | lastName | email            | gender | mobileNumber | dateBirth  | subjects              | hobbies       | file         | currentAddress                        | state   | city   | expected                       |
      ##@externaldata@./src/test/resources/data/Testdata.xlsx@Sheet1@2
   |Pedro   |Pablo   |pedro@correo.com   |Male   |3121234567   |30-04-2010   |Physics, Maths, Hindi   |Sports, Music   |original.png   |Calle 32 #12-12 Las Brisas – Medellin   |Haryana   |Karnal   |Thanks for submitting the form|


  @CP003
  Scenario Outline: Validar diligenciamiento exitoso de formulario completar campos obligatorios
    And Yo cargo los datos del estudiante
      | firstName   | lastName   | email   | gender   | mobileNumber   | dateBirth   | subjects   | hobbies   | file   | currentAddress   | state   | city   | expected   |
      | <firstName> | <lastName> | <email> | <gender> | <mobileNumber> | <dateBirth> | <subjects> | <hobbies> | <file> | <currentAddress> | <state> | <city> | <expected> |
    When Yo diligencio el formulario solo con datos obligatorios
    Then Yo verifico que se muestre el mensaje esperado
    And Yo verifico los datos obligatorios en la ventana de confirmacion

    Examples:
      | firstName | lastName | email            | gender | mobileNumber | dateBirth  | subjects              | hobbies       | file         | currentAddress                        | state   | city   | expected                       |
      ##@externaldata@./src/test/resources/data/Testdata.xlsx@Sheet1@3
   |Pedro   |Pablo   |pedro@correo.com   |Male   |3121234567   |30-04-2010   |Physics, Maths, Hindi   |Sports, Music   |original.png   |Calle 32 #12-12 Las Brisas – Medellin   |Haryana   |Karnal   |Thanks for submitting the form|


  @CP004
  Scenario Outline: Validar diligenciamiento de formulario si falta completar campos obligatorios
    And Yo cargo los datos del estudiante
      | firstName   | lastName   | email   | gender   | mobileNumber   | dateBirth   | subjects   | hobbies   | file   | currentAddress   | state   | city   | expected   |
      | <firstName> | <lastName> | <email> | <gender> | <mobileNumber> | <dateBirth> | <subjects> | <hobbies> | <file> | <currentAddress> | <state> | <city> | <expected> |
    When Yo diligencio el formulario con datos no obligatorios
    Then Yo deberia ver que se muestren los campos obligatorios de color rojo

    Examples:
      | firstName | lastName | email            | gender | mobileNumber | dateBirth  | subjects              | hobbies       | file         | currentAddress                        | state   | city   | expected                       |
      ##@externaldata@./src/test/resources/data/Testdata.xlsx@Sheet1@4
   |Pedro   |Pablo   |pedro@correo.com   |Male   |3121234567   |30-04-2010   |Physics, Maths, Hindi   |Sports, Music   |original.png   |Calle 32 #12-12 Las Brisas – Medellin   |Haryana   |Karnal   |rgba(220, 53, 69, 1)|
