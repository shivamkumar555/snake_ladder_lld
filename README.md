# snake_ladder_lld

Initialize board with given size (N × N)

Randomly place snakes & ladders using factory

Add players to a queue (round-robin turns)

Each turn:

Roll dice

Move player

Apply snake or ladder if present

Check win condition

Print board after every move

Game ends when a player reaches the last cell

# Do we need to build a system where multiple games are running simultaneously?
  => yes
  we need to create another class name as GameManager.
     - ConcurrentMap <ID, Game>
