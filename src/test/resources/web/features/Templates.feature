@BO @regresion @credenciales @smoke
Feature: Templates
  Como usuario de Coopsol Issuer
  Quiero acceder a los Tipos de credenciales

  Scenario Outline: crear un "Nuevo Template" ##MM-856
    Given el admin esta logueado en la web de coopsol
    When  el admin selecciona "Tipos de credenciales"
    And  el admin da click en el boton "Nuevo Template"
    And  el admin completa el Nombre <Nombre> y Emisor <Emisor>
    Then se muestran un mensaje de "Template creado exitosamente"

    Examples:
      | Nombre | Emisor      |
      | Test01 | Coopsol RSK |
      | Test02 | Coopsol     |

  Scenario: Eliminar un Template  ##MM-831
    Given el admin esta logueado en la web de coopsol
    And el admin tiene tipos de credenciales
    When el admin selecciona "Tipos de credenciales"
    And el admin hace clic en "Eliminar" un tipo de credencial
    And el admin hace clic en aceptar
    Then se muestra un mensaje de "Template eliminado exitosamente"