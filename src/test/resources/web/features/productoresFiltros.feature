@BO @regresion @productores
Feature: Productores - Filtros
  Como usuario de Coopsol
  Quiero poder filtrar productores
  para contar con un resultado acotado de los mismos

  Scenario Outline: Filtros de busqueda Exitoso: Credenciales en uso
    Given que el admin esta logueado en la web de coopsol.
    When el admin selecciona "Credenciales"
    When el admin selecciona "Credenciales en uso"
    When el admin completa el filtro "Apellido:" <Apellido>, "Nombre:" <Nombre>, "DNI:" <dni>, "DID:" <did>
    Then se muestran los productores de acuerdo al criterio de busqueda

    Examples:
      | Apellido | Nombre | dni | did |
      | www      | ww     | 222 | 222 |
