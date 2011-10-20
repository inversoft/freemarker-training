[#ftl/]
[#import "library.ftl" as library]
[@library.html]
  [@library.body]
    ${library.sum(20, 20, 2)}
  [/@library.body]
[/@library.html]