//
//  RCTWrapperReactRootViewController.m
//  NativeComp
//
//  Created by adrian.hartanto on 16/12/19.
//  Copyright © 2019 Facebook. All rights reserved.
//

#import "RCTWrapperReactRootViewController.h"

#import "RCTWrapper.h"
#import <React/RCTBridge.h>
#import <React/RCTRootView.h>

#import "RCTWrapperExampleView.h"

@implementation RCTWrapperReactRootViewController {
  RCTBridge *_bridge;
}

- (instancetype)initWithBridge:(RCTBridge *)bridge
{
  if (self = [super initWithNibName:nil bundle:nil]) {
    _bridge = bridge;
  }

  return self;
}

- (void)loadView
{
  RCTRootView *rootView =
    [[RCTRootView alloc] initWithBridge:_bridge
                             moduleName:@"bobobo"
                      initialProperties:@{}];

  rootView.backgroundColor = [UIColor whiteColor];

  UIActivityIndicatorView *progressIndicatorView =
    [[UIActivityIndicatorView alloc] initWithActivityIndicatorStyle:UIActivityIndicatorViewStyleWhiteLarge];
  [progressIndicatorView startAnimating];
  rootView.loadingView = progressIndicatorView;

  rootView.sizeFlexibility = RCTRootViewSizeFlexibilityWidthAndHeight;
  self.view = rootView;
}

@end
