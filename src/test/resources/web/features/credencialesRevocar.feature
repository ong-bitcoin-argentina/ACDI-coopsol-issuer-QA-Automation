@BO @regresion @smoke @credenciales
Feature: Credenciales - Revocar

  Como usuario de Coopsol quiero revocar credenciales pendientes

  #MM-826
  @Ignore
  Scenario Outline:  Caso de exito para revocar credenciales pendientes
    Given que el admin esta logueado en la web de coopsol.
    When hago click en la lista de acciones <Revocar>
    And  hago click en el boton "Confirmar"
    Then se muestra el mensaje  "La credencial se ha revocado exitosamente"

    Examples:
      | Revocar               |
      | Desvinculación        |
      | Expiración            |
      | Modificación de datos |
      | Reemplazo             |
      | Otro                  |


    #MM-818
  Scenario Outline: [Filtro-Acciones] Revocado de credencial exitoso
    Given que el admin esta logueado en la web de coopsol.
    When el admin selecciona "Credenciales en uso"
    When el admin selecciona "Revocar"
    When el admin selecciona el motivo <motivo>
    When el admin selecciona "Confirmar"
    Then se muestran un mensaje de "La credencial se ha revocado exitosamente"

    Examples:
      | motivo                |
      | Desvinculación        |
      | Expiración            |
      | Modificación de datos |
      | Reemplazo             |
      | Otro                  |


#MM-816
  @Ignore
  Scenario: [Seleccion multiple] Revocado de credencial exitoso
    Given que el admin esta logueado en la web de coopsol.
    And el admin selecciona "Credenciales en uso"
    When el admin selecciona multiples entradas
    When el admin selecciona "Revocar Seleccionados"
    Then se muestra mensaje "Se ha revocado exitosamente la credencial."

#MM-830
  @Ignore
  Scenario:  Verificar que se despliegue información de  Credenciales revocadas.
    Given que el admin esta logueado en la web de coopsol
    And se encuentra en la pantalla “Credenciales”
    When el admin selecciona el área "Credencial Revocadas"
    And el admin hace clic en el botón “+"
    Then se muestra la información de la credencial revocada seleccionada.