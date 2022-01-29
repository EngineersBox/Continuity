package com.engineersbox.continuity.mavenplugin;

import org.apache.maven.artifact.DependencyResolutionRequiredException;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.apache.maven.project.MavenProject;

import java.io.File;
import java.util.List;

@Mojo(name = "instrument", defaultPhase = LifecyclePhase.PROCESS_CLASSES, requiresDependencyResolution = ResolutionScope.COMPILE)
public class MainContinuityInstrumentationMojo extends AbstractMojo {

    @Parameter(
            defaultValue = "${project}",
            required = true,
            readonly = true
    )
    private MavenProject project;

    @Override
    public void execute() throws MojoExecutionException {
        final Log log = getLog();

        final File mainOutputFolder = new File(this.project.getBuild().getOutputDirectory());
        if (!mainOutputFolder.isDirectory()) {
            log.warn("Main folder doesn't exist -- nothing to instrument");
            return;
        }

        List<String> classpath;
        try {
            classpath = this.project.getCompileClasspathElements();
        } catch (final DependencyResolutionRequiredException ex) {
            throw new MojoExecutionException("Dependency resolution problem", ex);
        }

        log.debug("Processing main output folder ... ");
        instrumentPath(classpath, mainOutputFolder);
    }

    protected final void instrumentPath(final List<String> classpath,
                                        final File path) throws MojoExecutionException {
        final Log log = getLog();
        try {
            log.info("Starting continuity instrumentation");
            // TODO: Finish this
            log.info("Finished continuity instrumentation");
        } catch (final Exception e) {
            throw new MojoExecutionException("Unable to get classpath elements", e);
        }
    }
}
