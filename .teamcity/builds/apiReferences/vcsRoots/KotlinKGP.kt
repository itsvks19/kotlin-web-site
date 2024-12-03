package builds.apiReferences.vcsRoots

import BuildParams.KGP_RELEASE_TAG
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

object KotlinKGP : GitVcsRoot({
    name = "kotlin Gradle Plugin vcs root"
    url = "git@github.com:JetBrains/kotlin.git"
    branch = "refs/${if (KGP_RELEASE_TAG.startsWith("v")) "tags" else "heads"}/$KGP_RELEASE_TAG"
    branchSpec = """
        +:refs/heads/(*)
        +:refs/tags/(*)
    """.trimIndent()
    useTagsAsBranches = true
    authMethod = uploadedKey {
        uploadedKey = "teamcity"
    }
})