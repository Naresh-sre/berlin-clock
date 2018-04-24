Story: The Berlin Clock

Meta:
@scope interview

Narrative:
    As a clock enthusiast
    I want to tell the time using the Berlin Clock
    So that I can increase then number of ways that I can read the time

Scenario: Midnight
When the time is 00:00:00
Then the clock should look like
Y
OOOO
OOOO
OOOOOOOOOOO
OOOO

Scenario: Middle of the afternoon
When the time is 13:17:01
Then the clock should look like
O
RROO
RRRO
YYROOOOOOOO
YYOO

Scenario: Just before midnight
When the time is 23:59:59
Then the clock should look like
O
RRRR
RRRO
YYRYYRYYRYY
YYYY

Scenario: random time
When the time is 17:45:10
Then the clock should look like
Y
RRRO
RROO
YYRYYRYYROO
OOOO

Scenario: Midnight
When the time is 24:00:00
Then the clock should look like
Y
RRRR
RRRR
OOOOOOOOOOO
OOOO

Scenario: Hours out of Range
When the time is 25:00:00
Then the clock should look like
Time unit out of range: Hour

Scenario: Minutes out of Range
When the time is 24:60:00
Then the clock should look like
Time unit out of range: Minute

Scenario: Seconds out of Range
When the time is 23:59:60
Then the clock should look like
Time unit out of range: Second

Scenario: all time units are out of Range
When the time is 25:60:60
Then the clock should look like
Time unit out of range: Hour
Time unit out of range: Minute
Time unit out of range: Second

Scenario: invalid Time format 
When the time is '\u001D'     
Then the clock should look like
Invalid time format. Correct time format is hh:mm:ss.

Scenario: invalid Time format  with non-numeric 
When the time is  23:25:ii    
Then the clock should look like
Time values must be Integer: 23:25:ii

Scenario: Numeric Values 
When the time is  23:25:2.5    
Then the clock should look like
Time values must be Integer: 23:25:2.5





