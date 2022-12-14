@BO @regresion @credenciales @smoke
Feature: Templates
  Como usuario de Coopsol Issuer
  Quiero acceder a los Tipos de credenciales

  ##El nombre se genera de forma dinámica y queda concatenado al que se muestra en el example
  ##MM-856
  Scenario Outline: crear un "Nuevo Template"
    Given que el admin esta logueado en la web de coopsol.
    When  el admin selecciona "Tipos de credenciales"
    And  el admin da click en el boton "Nuevo Template"
    And  el admin completa el Nombre <Nombre> y Emisor <Emisor>
    Then se muestran un mensaje de "Template creado exitosamente"

    Examples:
      | Nombre | Emisor      |
      | Test01 | Coopsol RSK |
      | Test02 | Coopsol     |

  ##MM-831
  Scenario: Eliminar un Template
    Given que el admin esta logueado en la web de coopsol.
    And el admin tiene tipos de credenciales
    When el admin selecciona "Tipos de credenciales"
    And el admin hace clic en "Eliminar" un tipo de credencial
    And el admin hace clic en aceptar
    Then se muestran un mensaje de "Template eliminado exitosamente"

    ##MM-833
  Scenario Outline: Editar una categoria de credencial de un Template
    Given que el admin esta logueado en la web de coopsol.
    When el admin selecciona "Tipos de credenciales"
    And el admin selecciona el boton "Editar" al costado derecho del template del primer resultado.
    And el admin hace click en la categoria de la credencial
    And el admin elige la Categoria <Categoria>
    And el admin da click en "Guardar"
    Then se muestran un mensaje de "Template actualizado exitosamente"

    Examples:
      | Categoria  |
      | EDUCACIÓN  |
      | FINANZAS   |
      | VIVIENDA   |
      | IDENTIDAD  |
      | BENEFICIOS |
      | LABORAL    |
        