package com.dataartisans.flink.dataflow;

import com.google.auto.service.AutoService;
import com.dataartisans.flink.dataflow.FlinkPipelineOptions;
import com.dataartisans.flink.dataflow.FlinkPipelineRunner;
import com.google.cloud.dataflow.sdk.options.PipelineOptions;
import com.google.cloud.dataflow.sdk.options.PipelineOptionsRegistrar;
import com.google.cloud.dataflow.sdk.runners.PipelineRunner;
import com.google.cloud.dataflow.sdk.runners.PipelineRunnerRegistrar;
import com.google.common.collect.ImmutableList;

public class FlinkRunnerRegistrar {
  private FlinkRunnerRegistrar() { }

  @AutoService(PipelineRunnerRegistrar.class)
  public static class Runner implements PipelineRunnerRegistrar {
    @Override
    public Iterable<Class<? extends PipelineRunner<?>>> getPipelineRunners() {
      return ImmutableList.<Class<? extends PipelineRunner<?>>>of(FlinkPipelineRunner.class);
    }
  }

  @AutoService(PipelineOptionsRegistrar.class)
  public static class Options implements PipelineOptionsRegistrar {
    @Override
    public Iterable<Class<? extends PipelineOptions>> getPipelineOptions() {
      return ImmutableList.<Class<? extends PipelineOptions>>of(FlinkPipelineOptions.class);
    }
  }
}
