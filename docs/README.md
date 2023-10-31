# JRTB
Telegram bot for Javarush from community for community

# How it would work
Based on MVP Scope, we can specify next behaviours (here and after Telegram User, which is using JavaRush Telgegram bot will call User):
- User can subscribe on group of articles
- User can view list of gorup subscriptions on which user subscribes
- User can unsubscribe from gorup of articles
- User can set an inactive bot and do not receive notifications
- User can restart getting notifications

## Deployment
Deployment process as easy as possible:
Required software:
- terminal for running bash scripts
- docker
- docker-compose
- directories for environments:

  <root project>/.env/jrtb.env

  File contents
    - BOT_USERNAME=< username value >
    - BOT_TOKEN=< token value >

to deploy application, switch to needed branch and run bash script:

$ bash start.sh

That's all.