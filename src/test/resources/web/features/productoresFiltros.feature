@BO @regresion @productores
Feature: Productores - Filtros
  Como usuario de Coopsol
  Quiero poder filtrar productores
  para contar con un resultado acotado de los mismos

@Ignore
  Scenario Outline: Filtros de busqueda Exitoso de productores
    Given que el admin esta logueado en la web de coopsol.
    When el admin selecciona "Productores"
    When el admin completa el filtro "Apellido:" <Apellido>, "Nombre:" <Nombre>, "DNI:" <DNI>, "DID:" <DID>
    Then se muestran los resultados de acuerdo al criterio de busqueda

    Examples:
      | Apellido       | Nombre | DNI       | DID                                                 |
      | Diaz           | Juan   | 24277405  | did:ethr:0x540e93e1abe93dfe86a48f8fabb0252b3f483d67 |
      |                | Juan   | 24277405  | did:ethr:0x540e93e1abe93dfe86a48f8fabb0252b3f483d67 |
      | Diaz           |        | 24277405  | did:ethr:0x540e93e1abe93dfe86a48f8fabb0252b3f483d67 |
      | Diaz           | Juan   |           | did:ethr:0x540e93e1abe93dfe86a48f8fabb0252b3f483d67 |
      | Diaz           | Juan   | 24277405  |                                                     |
      |                |        |           |                                                     |