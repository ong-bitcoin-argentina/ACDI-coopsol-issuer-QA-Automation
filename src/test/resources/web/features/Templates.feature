@BO @regresion @credenciales @smoke
Feature: Templates
  Como usuario de Coopsol Issuer
  Quiero acceder a los Tipos de credenciales

  ##El nombre se genera de forma dinámica y queda concatenado al que se muestra en el example
  ##MM-856
  @prueba
  Scenario Outline: crear un "Nuevo Template"
    Given que el admin esta logueado en la web de coopsol.
    When  el admin selecciona "Tipos de credenciales"
    And  el admin da click en el boton "Nuevo Template"
    And  el admin completa el Nombre <Nombre> y Emisor <Emisor>
    Then se muestran un mensaje de "Template creado exitosamente"

    Examples:
      | Nombre | Emisor      |
      | Test01 | Coopsol RSK |
      #| Test02 | Coopsol     |

  ##MM-831
  Scenario: Eliminar un Template
    Given que el admin esta logueado en la web de coopsol.
    And el admin tiene tipos de credenciales
    When el admin selecciona "Tipos de credenciales"
    And el admin hace clic en "Eliminar" un tipo de credencial
    And el admin hace clic en aceptar
    Then se muestra un mensaje de "Template eliminado exitosamente"