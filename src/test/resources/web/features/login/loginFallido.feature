@bo @regresion @smoke @login

Feature: Como usuario de DIDI quiero no poder Loguearme con credenciales inválidas
@Nahuel
  Scenario Outline: Login Fallido
    Given El usuario se encuentra en <Coopsol Issuer>
    When El usuario completa Usuario con '<user>'
    When El usuario completa Contraseña con '<password>'
    When Hace click en el boton 'login'
    Then <respuesta>

    Examples:
      | user          | password    | respuesta                                                     |
      |               | Crowdar387! | Se muestra el mensaje "Campo obligatorio"                     |
      | crowdar_test2 |             | Se muestra el mensaje "Campo obligatorio"                     |
#      |               |             | Se muestra el mensaje "Los datos ingresados no son correctos" |