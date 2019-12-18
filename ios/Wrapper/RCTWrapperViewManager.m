//
//  RCTWrapperViewManager.m
//  NativeComp
//
//  Created by adrian.hartanto on 16/12/19.
//  Copyright © 2019 Facebook. All rights reserved.
//

#import "RCTWrapperViewManager.h"

#import "RCTWrapperShadowView.h"
#import "RCTWrapperView.h"

@implementation RCTWrapperViewManager

RCT_EXPORT_MODULE()

- (RCTShadowView *)shadowView
{
  return [[RCTWrapperShadowView alloc] initWithBridge:self.bridge];
}

- (UIView *)view
{
  return [[RCTWrapperView alloc] initWithBridge:self.bridge];
}

@end
