//
//  RCTWrapperExampleViewController.m
//  NativeComp
//
//  Created by adrian.hartanto on 16/12/19.
//  Copyright © 2019 Facebook. All rights reserved.
//

#import "RCTWrapperExampleViewController.h"

#import "RCTWrapper.h"

#import "RCTWrapperExampleView.h"

@implementation RCTWrapperExampleViewController

- (void)loadView {
  self.view = [RCTWrapperExampleView new];
}

@end

RCT_WRAPPER_FOR_VIEW_CONTROLLER(RCTWrapperExampleViewController)
