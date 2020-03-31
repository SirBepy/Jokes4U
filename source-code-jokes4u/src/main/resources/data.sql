INSERT INTO Category
  (id, name)
VALUES
  (1, 'Yo Momma'),
  (2, 'Programming'),
  (3, 'Pun');


INSERT INTO Joke
  (category_id_FK, content, likes, dislikes)
VALUES
  (1, 'Yo mama is so fat, she fell down and rocked herself to sleep trying to get back up.', 5, 0),
  (1, 'Yo Momma so old she remembers when yo momma jokes were still funny.', 7, 1),
  (2, 'Debugging. Being the detective in a crime movie where you are also the murderer.', 15, 8),
  (3, 'My girlfriend always prefers the stairs, whereas I always like to take the elevator... I guess we are raised differently.', 2, 0),
  (3, 'I guess you could say that Rome was split in two by a pair of Ceasars.', 3, 4);

/**
INSERT INTO Category
  (id, name)
VALUES
  (4, 'Food'),
  (5, 'Animals');

INSERT INTO Joke
  (category_id_FK, content)
VALUES
  (1, 'Yo momma is so ugly when she tried to join an ugly contest they said, "Sorry, no professionals.'),
  (1, 'Yo momma so fat, that when she fell, no one was laughing but the ground was cracking up. '),
  (1, 'Yo momma is so ugly she made One Direction go another direction. '),
  (1, 'Yo momma so stupid, she put two quarters in her ears and thought she was listening to 50 Cent. '),
  (1, 'Yo momma so dumb, when yall were driving to Disneyland, she saw a sign that said "Disneyland left," so she went home.'),
  (1, 'Yo momma is so stupid she brought a spoon to the Super Bowl. '),
  (1, 'Yo momma is so stupid she took a ruler to bed to see how long she slept.'),
  (1, 'Yo momma so fat she needs cheat codes for Wii Fit. '),
  (1, 'Yo mamma is so ugly when she took a bath the water jumped out.'),
  (1, 'Yo momma so spooky when she went into a haunted house she came out with a job application. '),
  (1, 'Yo momma is so fat she walked past the TV and I missed 3 episodes. '),
  (1, 'Yo momma is so dumb that she thought Dunkin Donuts was a basketball team. '),
  (1, 'Yo momma is so stupid that she sat on the TV to watch the couch. '),
  (1, 'Yo momma so stupid, she got hit by a parked car. '),
  (1, 'Yo momma so stupid, she returned a doughnut because it had a hole in it. '),
  (1, 'Yo momma is so stupid she put airbags on her computer in case it crashed. '),
  (2, 'Whats the object-oriented way to become wealthy? Inheritance!'),
  (2, 'Why did the programmer quit his job? Because he didnt get arrays. (a raise)'),
  (2, 'Why do Java programmers have to wear glasses? Because they dont C#.'),
  (2, 'The programmer got stuck in the shower because the shampoo bottle said - lather, rinse, repeat!'),
  (2, 'A SQL query goes into a bar, walks up to two tables and asks “Can I join you?”'),
  (2, '[“hip”, “hip”] -> "array!"'),
  (2, 'A programmer was walking out of the door for work, his wife said “while youre out, buy some milk”. He never came home.'),
  (2, 'Form: What is your address? Programmer: 173.168.15.10.'),
  (2, 'Why do programmers always get Christmas and Halloween mixed up? Because DEC 25 = OCT 31'),
  (2, 'Unix is user friendly. Its just very particular about who its friends are.'),
  (2, 'All programmers are playwrights and all computers are lousy actors.'),
  (2, 'There are only 10 types of people in the world: Those that understand binary and those that dont.'),
  (2, 'I decided to make my password "incorrect" because if I type it in wrong, my computer will remind me, "Your password is incorrect."'),
  (2, 'Programmer (noun.) A machine that turns coffee into code!'),
  (2, 'What do computers eat for a snack? Microchips!'),
  (2, 'What computer sings the best? A Dell.'),
  (3, 'Light travels faster than sound. Thats why some people appear bright until you hear them speak.'),
  (3, 'I was wondering why the ball was getting bigger. Then it hit me.'),
  (3, 'I have a few jokes about unemployed people, but none of them work.'),
  (3, '"I have a split personality," said Tom, being frank.'),
  (3, 'Last night, I dreamt I was swimming in an ocean of orange soda. But it was just a Fanta sea.'),
  (3, 'I lost my job at the bank on my very first day. A woman asked me to check her balance, so I pushed her over.'),
  (3, 'I went to buy some camouflage trousers yesterday but couldnt find any.'),
  (3, 'I tried to sue the airline for losing my luggage. I lost my case.'),
  (3, 'Jill broke her finger today, but on the other hand she was completely fine.'),
  (3, 'Why was six scared of seven? Because seven "ate" nine.'),
  (4, 'My friend thinks he is smart. He told me an onion is the only food that makes you cry, so I threw a coconut at his face.'),
  (4, 'A teacher asked her students to use the word "beans" in a sentence. "My father grows beans," said one girl. "My mother cooks beans," said a boy. A third student spoke up, "We are all human beans."'),
  (4, 'Why did the can crusher quit his job? Because it was soda pressing.'),
  (4, 'How much room is needed for fungi to grow? As mushroom as possible.'),
  (4, 'If you have 13 apples in one hand and 10 oranges in the other, what do you have? Big hands.'),
  (4, 'Why do the French eat snails? They dont like fast food.'),
  (4, 'What do you call a sad coffee? Depresso.'),
  (4, 'A lot of people cry when they cut an onion. The trick is not to form an emotional bond.'),
  (5, 'What happens to a frogs car when it breaks down? It gets toad away.'),
  (5, 'Why did the witches team lose the baseball game? Their bats flew away.'),
  (5, 'Why couldnt the leopard play hide and seek? Because he was always spotted.'),
  (5, 'How do you count cows? With a cowculator.'),
  (5, 'What do you call a pig that does karate? A pork chop.'),
  (5, 'Why are frogs always so happy?  They eat whatever bugs them.'),
  (5, 'Whats the difference between a guitar and a fish? You can tune a guitar, but you cant tuna fish.'),
  (5, 'What type of sandals do frogs wear? Open-toad!'),
  (5, 'Teacher: "Name a bird with wings but cant fly." Student: "A dead bird, sir."'),
  (5, 'Why do the French eat snails? They dont like fast food.'),
  (5, 'What do cats eat for breakfast? Mice Krispies.'),
  (5, 'Teacher: "I asked you to draw a cow and grass, but I only see a cow. Where is grass?" Student: "The cow ate the grass, sir."'),
  (5, 'What do you get when you cross a fish and an elephant? Swimming trunks.'),
  (5, 'Why did the chicken cross the playground?  To get to the other slide!'),
  (5, 'How come oysters never donate to charity? Because they are shellfish.'),
  (5, 'What do you call a rabbit that has fleas? Bugs bunny.'),
  (5, 'What kind of key opens a banana? A monkey.');
  **/
