@bo @regresion @smoke @login

Feature: Como usuario de DIDI quiero Loguearme para poder operar en el BO.

  Scenario: Login exitoso
    Given El usuario se encuentra en <Coopsol Issuer>
    When El usuario completa Usuario con <user>
    When El usuario completa Contraseña con <password>
    When Hace click en el boton 'login'
    Then Se muestra la página de Credenciales