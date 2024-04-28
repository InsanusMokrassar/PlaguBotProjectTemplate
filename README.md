# project_name

It is template for common project based on several technologies:

* [KTgBotAPI Kotlin Library](https://docs.inmo.dev/tgbotapi/index.html) + [PlaguBot](https://docs.inmo.dev/plagubot/index.html)
* [Kotlinx Exposed](https://github.com/JetBrains/Exposed) (for databases) + [SQLite](https://github.com/xerial/sqlite-jdbc) (as default database engine)
* [Kotlin Koin](https://insert-koin.io) (for DI)

## Start work with template

* Replace `project_group` in whole project by your project group
* Replace `project_name` in whole project by your project name

## Launching

Template contains run-ready [runner](./runner) folder with [sample.json](./runner/sample.json) which
you may copy as `local.json` in project (file will not be indexed by git). After replacement of value in
`botToken` field you may run your bot with command:

```bash
./gradlew run --args="/path/to/local.json"
```

where `/path/to/local.json` is an absolute path to configuration `json` file
