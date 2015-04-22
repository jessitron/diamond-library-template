(ns leiningen.new.diamond-library
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "diamond-library"))

(defn diamond-library
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' diamond-library project.")
    (->files data
             ["src/{{sanitized}}/foo.clj" (render "foo.clj" data)])))
