(ns leiningen.new.diamond-library
  (:require [leiningen.new.templates :refer [renderer sanitize year ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "diamond-library"))

(defn diamond-library
  "A whole structure: impl, schema, gen, spec"
  [name]
  (let [data {:name name
              :schema-project (str name "-schema")
              :gen-project (str name "-gen")
              :impl-project (str name "-impl")
              :specs-project (str name "-spec")
              :sanitized (sanitize name)
              :year (year)}]
    (main/info "Generating four fresh projects for your very much library implementation")
    (->files data
             ["README.md" (render "toplevel-README.md" data)]
             [".gitignore" (render "gitignore" data)]
             )))
