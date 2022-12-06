@BO @regresion @credenciales @smoke
Feature: Como usuario de Coopsol Issuer quiero acceder a los Tipos de credenciales

  @prueba
  Scenario Outline: crear un "Nuevo Template"
    Given el admin esta logueado en la web de coopsol
    When  el admin selecciona "Tipos de credenciales"
    And  el admin da click en el boton "Nuevo Template"
    And  el admin completa el Nombre <Nombre> y Emisor <Emisor>
    Then se muestran un mensaje de "Template creado exitosamente"

    Examples:
      | Nombre | Emisor      |
      | Test01 | Coopsol RSK |
      | Test02 | Coopsol     |
