# diamond-client

A Leiningen template for a library:
create a directory with related projects. This includes
- the library implementation
- the schemas that define its input and output
- the generators that produce valid input and output samples
- the specification, which uses the generators to test the client.

The intraproject dependencies look like this:

       ┌──────┐
    ┌──│ spec │────┐
    │  └──────┘    │
    ▼      Λ       ▼
┌──────┐  ╱ ╲  ┌──────┐
│ impl │ ▕   ▏ │ gen  │
└──────┘  ╲ ╱  └──────┘
    │      V       │
    │  ┌──────┐    │
    └─▶│schema│◀───┘
       └──────┘

Any client of this library will have a source dependency on impl and a
test dependency on the generators.

┌──────────────────────┐
│┌────┐  client ┌────┐ │
││ src│         │test│ │
│└────┘         └────┘ │
│   │              │   │
└───┼──────────────┼───┘
    │  ┌──────┐    │
    ├──│ spec │────┤
    │  └──────┘    │
    ▼      Λ       ▼
┌──────┐  ╱ ╲  ┌──────┐
│ impl │ ▕   ▏ │  gen │
└──────┘  ╲ ╱  └──────┘
    │      V       │
    │  ┌──────┐    │
    └─▶│schema│◀───┘
       └──────┘

## Usage

lein new diamond-library <your-library-name>

## License

Copyright © 2015 Jessica Kerr

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
