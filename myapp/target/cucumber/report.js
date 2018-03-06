$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./src/Features/InternationalPriceList.feature");
formatter.feature({
  "line": 1,
  "name": "Cucumber can convert a Gherkin table to to a map.",
  "description": "This an example of a more complicated price list.",
  "id": "cucumber-can-convert-a-gherkin-table-to-to-a-map.",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "An international coffee shop must handle currencies",
  "description": "",
  "id": "cucumber-can-convert-a-gherkin-table-to-to-a-map.;an-international-coffee-shop-must-handle-currencies",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "the price list for an international coffee shop",
  "rows": [
    {
      "cells": [
        "product",
        "currency",
        "price"
      ],
      "line": 6
    },
    {
      "cells": [
        "coffee",
        "EUR",
        "1"
      ],
      "line": 7
    },
    {
      "cells": [
        "donut",
        "SEK",
        "18"
      ],
      "line": 8
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "I buy 1 coffee and 1 donut",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "should I pay 1 EUR and 18 SEK",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs.thePriceListForAnInternationalCoffeeShop(Price\u003e)"
});
formatter.result({
  "duration": 190465056,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 6
    },
    {
      "val": "coffee",
      "offset": 8
    },
    {
      "val": "1",
      "offset": 19
    },
    {
      "val": "donut",
      "offset": 21
    }
  ],
  "location": "MyStepdefs.iBuyCoffeeAndDonut(int,String,int,String)"
});
formatter.result({
  "duration": 384211,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 13
    },
    {
      "val": "18",
      "offset": 23
    }
  ],
  "location": "MyStepdefs.shouldIPayEURAndSEK(int,int)"
});
formatter.result({
  "duration": 2493578,
  "status": "passed"
});
});