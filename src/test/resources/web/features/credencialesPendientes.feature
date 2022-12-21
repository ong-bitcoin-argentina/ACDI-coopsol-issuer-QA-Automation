@BO @regresion @smoke @credenciales

Feature: Credenciales

  Como usuario de Coopsol
  quiero emitir o eliminar credenciales pendientes


 ##MM-819
  Scenario: Emitir Exitosamente credenciales pendientes
    Given estoy logueado en la web de coopsol con el usuario "crowdar" y password "Crowdar387!"
    When hago click en Emitir
    Then se muestra el mensaje "Se ha emitido exitosamente la credencial"


  @Ignore #MM-936
  Scenario: Eliminar exitosamente una credencial pendiente
    Given que el admin esta logueado en la web de coopsol.
    When selecciono la primer credencial haciendo click en el checkbox ubicado a la izquierda
    When hago click en el boton "ELIMINAR SELECCIONADOS”
    Then se muestra el mensaje "Se ha revocado exitosamente la credencial"
