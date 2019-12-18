//
//  RCTWrapperReactRootViewManager.m
//  NativeComp
//
//  Created by adrian.hartanto on 16/12/19.
//  Copyright © 2019 Facebook. All rights reserved.
//

#import "RCTWrapperReactRootViewManager.h"

#import "RCTWrapperView.h"
#import "RCTWrapperViewControllerHostingView.h"

#import "RCTWrapperReactRootViewController.h"

@implementation RCTWrapperReactRootViewManager

RCT_EXPORT_MODULE()

- (UIView *)view
{
  RCTWrapperViewControllerHostingView *contentViewControllerHostingView =
    [RCTWrapperViewControllerHostingView new];

  contentViewControllerHostingView.contentViewController =
    [[RCTWrapperReactRootViewController alloc] initWithBridge:self.bridge];

  RCTWrapperView *wrapperView = [super view];
  wrapperView.contentView = contentViewControllerHostingView;
  return wrapperView;
}

@end
