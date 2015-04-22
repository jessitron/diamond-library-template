(ns leiningen.new.jessitron
  (:require [leiningen.new.templates :refer [renderer sanitize year ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "diamond-library"))

(defn diamond-library
  "A whole structure: impl, schema, gen, spec"
  [name]
  (let [data {:name name
              :sanitized (sanitize name)
              :year (year)}]
    (main/info "Generating four fresh projects for your very much library implementation")
    (->files data
             ["src/{{sanitized}}/core.clj" (render "core.clj" data)]
             ["project.clj" (render "project.clj" data)]
             ["README.md" (render "README.md" data)]
             ["LICENSE" (render "LICENSE" data)]
             [".gitignore" (render "gitignore" data)]
             ["test/{{sanitized}}/core_test.clj" (render "test.clj" data)]
             )))
