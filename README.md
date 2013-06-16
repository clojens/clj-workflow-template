# niubi - template of a clojure workflow that creates application
  instances on command

Based on Stuart Sierra's blog post at:
http://thinkrelevance.com/blog/2013/06/04/clojure-workflow-reloaded

The system constructor has two main tasks:
* Start up the database and seed it with a schema and a few test
values. It also adds a map of some database entities to the system
variable for easy testing (schema and data files are in resources/)).
* Start a webserver at port 8080. This can be changed from within the
system-dev function.

## Usage

Start a repl, then call (reset) to load up a variable called 'system'
that contains the whole environment. 

To change anything, modify the code in dev/user.clj, and src/system.clj

Add the below to your .emacs to call reset with a chord. I chose
Ctrl-c a, but you can modify that to be whatever floats your boat:
(global-set-key (kbd "C-c a") (kbd "(reset) <return>"))

## License

Copyright © 2013 Timothy Galebach
