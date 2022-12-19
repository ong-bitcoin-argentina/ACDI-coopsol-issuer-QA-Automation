@BO @regresion @smoke @credenciales @BUG_946
Feature: Credenciales - Filtros
  Como usuario de Coopsol
  quiero acceder a credenciales en uso para poder
  REVOCARLAS segun FILTRO aplicado

  @BUG_946
    #MM-815
  Scenario Outline: Filtros de busqueda Exitoso
    Given que el admin esta logueado en la web de coopsol.
    When el admin selecciona "Credenciales"
    When el admin selecciona "Credenciales en uso"
    When el admin completa el filtro "Tipo:" <Tipo>, "Nombre:" <Nombre>, "Apellido:" <Apellido>, "Desde:" <Desde>, "Hasta:" <Hasta>
    Then se muestran los resultados de acuerdo al criterio de busqueda

    Examples:
      | Tipo           | Nombre | Apellido | Desde      | Hasta      |
      | Productiva RSK | David  | Morelos  | 08/08/2022 | 08/08/2022 |
      |                | David  | Morelos  | 08/08/2022 | 08/08/2022 |
      |                |        | Morelos  | 08/08/2022 | 08/08/2022 |
      |                |        |          | 08/08/2022 | 08/08/2022 |
      |                |        |          |            | 08/08/2022 |
      | Productiva RSK | David  | Morelos  |            |            |
      | Productiva RSK | David  |          |            |            |
      | Productiva RSK |        |          |            |            |
      |                | David  |          |            |            |
      |                |        | Morelos  |            |            |
      |                |        |          | 08/08/2022 |            |
      | Productiva RSK | David  |          | 08/08/2022 |            |
      | Productiva RSK |        | Morelos  |            | 08/08/2022 |


