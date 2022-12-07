@bo @regresion @login
Feature: Login
  Como usuario de DIDI
  quiero Loguearme
  para poder operar en el BO.

  Background:
    Given El usuario se encuentra en <Coopsol Issuer>

  @smoke #MM-827
  Scenario: Login exitoso
    When El usuario completa Usuario con <user>
    When El usuario completa Contraseña con <password>
    When Hace click en el boton 'login'
    Then Se muestra la página de Credenciales

  #MM-1109
  Scenario Outline: Login Fallido
    When El usuario completa Usuario con '<user>'
    When El usuario completa Contraseña con '<password>'
    When Hace click en el boton 'login'
    Then Se muestra el mensaje <respuesta>

    @Ignore
    Examples:
      | user          | password    | respuesta                               |
      |               | Crowdar387! | "Campo obligatorio"                     |
      | crowdar_test2 |             | "Campo obligatorio"                     |
      | ssadasdas     | sadsadsada  | "Los datos ingresados no son correctos" |
      |               |             | "Campo obligatorio"                     |

  @smoke @Nahuel #MM-828
  Scenario: Log out exitoso
    Given que el admin esta logueado en la web de coopsol.
    When el usuario selecciona "Cerrar sesión"
    Then se redirije a pantalla del Log in