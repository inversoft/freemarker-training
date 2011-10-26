[#ftl/]
[#import "library.ftl" as library]

[#assign title="Hello from basic.ftl" in library/]
[#assign debug=true in library/]

[@library.html]
  [@library.body tag="h1"]
    <h3>Sum</h3>
    <p>
      ${library.sum(20, 20, 2)}
    </p>

    <h3>SumList</h3>
    <p>
      ${library.sumList([1, 1, 40])}
    </p>
  [/@library.body]
[/@library.html]
